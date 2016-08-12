
/*
 * Veronica Baker
 * Intro to CS -004
 */
import java.util.Scanner;
public class Loan 
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		//ask for loan
		System.out.println("Enter the loan amount:");
		double loan = input.nextDouble();
		//ask for years
		System.out.println("Enter the number of years:");
		double years = input.nextDouble();
		//ask for interest rate
		System.out.println("Enter the interest rate (annual):");
		double interestRate = input.nextDouble();
		double monthlyInterestRate = interestRate / 1200;
		double balance = loan;
		double monthlyPayment = loan * monthlyInterestRate / (1 - Math.pow(1 / (1 + monthlyInterestRate),  years * 12));
		double interest;
		double principle;
		//display monthly and total payment
		System.out.printf("Monthly Payment: %.2f\n" , (float)(monthlyPayment * 100) / 100.0);
		System.out.printf("Total Payment: %.2f\n", (float)(monthlyPayment * 12 * years * 100) / 100.0);
		//table header
		System.out.println("Payment#\tInterest\tPrincipal\tBalance");
		//
		for (int i = 1; i <= years * 12; i++) 
		{
            interest = (int)(monthlyInterestRate * balance * 100) / 100.0;
            principle = (int)((monthlyPayment - interest) * 100) / 100.0;
            balance = (int)((balance - principle) * 100) / 100.0;
            System.out.printf(i + "\t\t\t%.2f\t\t%.2f\t\t%.2f\n", interest, principle, balance);
		}
		input.close();
	}
}
