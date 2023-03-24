/*The program is a simple Java Car Loan Payment Calculator that calculates the monthly payment for a car loan based on the loan amount, loan length, interest rate, and down payment provided by the user.

First, it sets some initial variables for the car loan, loan length, interest rate, and down payment. Then, it checks if the loan length and interest rate are greater than zero, and if the down payment is less than the car loan, in order to ensure that the loan parameters are valid.

If the parameters are valid, the program calculates the remaining balance on the loan after the down payment, the number of months in the loan term, the monthly balance, the monthly interest rate, the interest owed each month, and finally, the monthly payment required to pay off the loan.

Finally, if the loan parameters are valid, the program prints out the calculated monthly payment for the user to see.*/


public class CarLoan {
    public static void main(String[] args) {

        int carLoan = 10000;
        int loanLength = 3;
        int interestRate = 5;
        int downPayment = 2000;

        if (loanLength <= 0 || interestRate <= 0) {
            System.out.println("Invalid loan parameters. Please enter a loan length and interest rate greater than zero.");
        } else if (downPayment >= carLoan) {
            System.out.println("Invalid down payment. Down payment must be less than the car loan.");
            // Add additional error handling code here if necessary
        } else {
            int remainingBalance = carLoan - downPayment;
            int months = loanLength * 12;
            int monthlyBalance = remainingBalance / months;
            double monthlyRate = (double) interestRate / 12 / 100;
            double interest = Math.round(monthlyBalance * monthlyRate * 100.0) / 100.0;
            double monthlyPayment = monthlyBalance + interest;

            System.out.println(monthlyPayment); // print monthly payment
        }
    }
}

