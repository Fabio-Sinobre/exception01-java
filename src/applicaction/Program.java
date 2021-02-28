package applicaction;
/**
 * 
 * @author Fabio D. Sinobre.
 *
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner; 

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Número do quarto: ");
			int number = sc.nextInt();
			System.out.println("Digite a data de entrada dd/mm/aaaa:");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reserva: " + reservation);
			
			System.out.println();
			System.out.println("Digete a nova data inicio para atualizar a reserva dd/mm/aaaa: ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Digite a nova data de saída dd/mm/aaaa: ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Nova data de reserva: " + reservation);
		}
		catch(ParseException e) {
			System.out.println("Formato da data invalido!");
		}
		catch(DomainException e) {
			System.out.println("Erro na reserva:" + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		
		sc.close();
	}

}
