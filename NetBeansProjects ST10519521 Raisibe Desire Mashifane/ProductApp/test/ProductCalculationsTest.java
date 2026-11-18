import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class ProductCalculationsTest {

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        // Arrange - Valid data from screenshot: Price = 3500
        IProductCalculations calc = new iProductClaculations(3500);

        // Act
        double result = calc.GetVat();

        // Assert - 3500 * 0.15 = 525.0
        assertEquals(525.0, result, 0.01);
    }

    @Test
    public void GetCommission_WithValidData_ReturnsCorrectValue() {
        IProductCalculations calc = new iProductClaculations(3500);
        assertEquals(175.0, calc.GetCommision(), 0.01);
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        IProductCalculations calc = new iProductClaculations(3500);
        assertEquals(4200.0, calc.GetTotal(), 0.01);
    }
}