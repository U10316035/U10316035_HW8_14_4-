/*U10316035
 *Lin Tz Hau
 */

public class Loan {
  private double annualInterestRate;
  private int numberOfYears;
  private double loanAmount;
  private java.util.Date loanDate;

  /** Default constructor */
  public Loan() {
    this(2.5, 1, 1000);
  }

  /** Construct a loan with specified annual interest rate,
      number of years and loan amount 
    */
  public Loan(double annualInterestRate, int numberOfYears,
      double loanAmount) {
	//set arguments to throw exceptions
    setAnnualInterestRate(annualInterestRate);
    setNumberOfYears(numberOfYears);
    setLoanAmount(loanAmount);
    loanDate = new java.util.Date();
  }

  /** Return annualInterestRate */
  public double getAnnualInterestRate() {
    return annualInterestRate;
  }

  /** Set a new annualInterestRate */
  public void setAnnualInterestRate(double annualInterestRate)
	//AnnualInterestRate throws IllegalArgumentException 
	throws IllegalArgumentException {
		if(annualInterestRate > 0)
			this.annualInterestRate = annualInterestRate;
		else 
			throw new IllegalArgumentException(
				" annualInterestRate can't less than or equal to zero!!!");
	}

  /** Return numberOfYears */
  public int getNumberOfYears() {
    return numberOfYears;
  }

  /** Set a new numberOfYears */
  public void setNumberOfYears(int numberOfYears)
	//NumberOfYears throws IllegalArgumentException 
	throws IllegalArgumentException {
		if( numberOfYears > 0)
			this.numberOfYears = numberOfYears;
		else
			throw new IllegalArgumentException(
				" numberOfYears can't less than or equal to zero!!!");
	}

  /** Return loanAmount */
  public double getLoanAmount() {
    return loanAmount;
  }

  /** Set a newloanAmount */
  public void setLoanAmount(double loanAmount)
	//LoanAmount throws IllegalArgumentException 
	throws IllegalArgumentException{
		if( loanAmount > 0)
			this.loanAmount = loanAmount;
		else
			throw new IllegalArgumentException(
				" loanAmount can't less than or equal to zero!!!");
	}

  /** Find monthly payment */
  public double getMonthlyPayment() {
    double monthlyInterestRate = annualInterestRate / 1200;
    double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
      (Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));
    return monthlyPayment;    
  }

  /** Find total payment */
  public double getTotalPayment() {
    double totalPayment = getMonthlyPayment() * numberOfYears * 12;
    return totalPayment;    
  }

  /** Return loan date */
  public java.util.Date getLoanDate() {
    return loanDate;
  }
 
  public static void main(String[] args){
	  //test if setAnnualInterestRate(annualInterestRate) throws IllegalArgumentException works
	  try{
		Loan test1 = new Loan(-1, 1, 1);
	  }catch(IllegalArgumentException ex){
		  System.out.println(ex);
	  }
	  //test if setNumberOfYears(numberOfYears) throws IllegalArgumentException works
	  try{
		Loan test2 = new Loan(1, -1, 1);
	  }catch(IllegalArgumentException ex){
		  System.out.println(ex);
	  }
	  //test if setLoanAmount(loanAmount) throws IllegalArgumentException works
	  try{
		Loan test3 = new Loan(1, 1, -1);
	  }catch(IllegalArgumentException ex){
		  System.out.println(ex);
	  }
  }
  
}
