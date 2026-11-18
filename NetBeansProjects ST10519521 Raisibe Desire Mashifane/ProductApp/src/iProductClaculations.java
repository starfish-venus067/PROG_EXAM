
public class iProductClaculations implements IProductCalculations {
    private double price;
    
public iProductClaculations(double price){
    this.price = price;
}    
    @Override
    public double GetVat() {
        return price * 0.15;
    }

    @Override
    public double GetCommision() {
        return price * 0.05;
    }

    @Override
    public double GetTotal() {
       return price +GetVat() + GetCommision();
               }
  
    
}
