/*
Class for solution square Equation like ax^2 + bx + c = 0, with integer params
 */
public class Solution {
  private final int firstParam;
  private final int secondParam;
  private final int thirdParam;
  
  public Solution(int firstParam, int secondParam, int thirdParam) {
    if(firstParam == 0) {
      System.out.println("incorrect first parametr, now first parametr = 1");
    }
    this.firstParam = Math.max(1, firstParam);
    this.secondParam = secondParam;
    this.thirdParam = thirdParam;
  }
  
  public int getDiscriminant() {
    return (int)Math.pow(this.secondParam, 2) - (4 * this.firstParam * this.thirdParam);
  }
  
  public boolean isZero(int number) {
    return number == 0;
  }
  
  public boolean isNegative(int number) {
    return number < 0;
  }
  public String[] getSolution() {
    String[] roots = new String[2];
    int discriminant = this.getDiscriminant();
    if(this.isNegative(discriminant)) {
      roots = this.getComplexityRoots(discriminant);
    } else if(this.isZero(discriminant)) {
        roots[0] = String.valueOf((double)(-this.secondParam) / (2 * firstParam));
        roots[1] = roots[0];
    } else {
      double numerator = -this.secondParam + Math.sqrt(discriminant);
      double denominator = 2.0 * this.firstParam;
      roots[0] = String.valueOf(numerator / denominator);
      numerator = -this.secondParam - Math.sqrt(discriminant);
      roots[1] = String.valueOf(numerator / denominator);
    }
    return roots;
  }
  private String[] getComplexityRoots(int discriminant) {
    String[] roots = new String[2];
    double denominator = 2.0 * this.firstParam;
    double realPart = -this.secondParam / denominator;
    double imagePart = Math.sqrt(-discriminant) / denominator;
    String tmp = String.format("i√%.2f", Math.pow(imagePart,2));
    roots[0] = String.format("%f + %s", realPart, tmp);
    roots[1] = String.format("%f - %s", realPart, tmp);
    return roots;
  }
}
