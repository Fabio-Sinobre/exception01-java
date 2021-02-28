package model.entities;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {//função converte data em milissigundos depois em dias.
		long diff = checkOut.getTime() - checkIn.getTime();//devolve em milissigundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);// coverte para dias
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now)||checkOut.before(now)){
			throw new DomainException("A data da reserva deve ser futura!");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("A data de saída deve ser posterior a data de entrada!");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Quarto"
				+ roomNumber
				+ "data de entrada: "
				+ sdf.format(checkIn)
				+ ", "
				+ duration()
				+ " noite";
	}

}
