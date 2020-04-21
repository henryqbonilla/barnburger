/***************************************
*Program Name: Barn Burger Ordering System
*Programmer's Name: Henry Bonilla
* Program Description: This is a Graphic
* User Interface Program that has burger
* options for users to choose and quantity
* option for multiple same orders. The user
* also has the option to add new orders to
* current current or to start over.
****************************************/

package barnburger;

import java.text.NumberFormat;
import java.util.Locale;


public class BurgerOrder 
{
    //sets up US currency format for numbers
    private static final NumberFormat CF = NumberFormat.getCurrencyInstance(Locale.US);
    
    public enum BurgerSize{Single,Double}
    
    //final cost setup for items
    public static final double DEFAULT_PRICE = 3.50;
    public static final String DEFAULT_TYPE = "Item";
    
    private static final double SINGLE_PRICE = 3.50;
    public static final double  DOUBLE_PRICE = 4.75;
    
    private static final double CHEESE_COST = 0.50;
    private static final double BACON_COST = 1.25;
    private static final double MEAL_COST = 4.00;
    
    //boolean item addition setup
    private boolean cheeseSelected = false;
    private boolean baconSelected = false;
    private boolean mealSelected = false;
    
    private BurgerSize burgerSize;
    private double sizeCost;
    private double totalCost = 0;
    private int quantity;
    private static double finalCost = 0;
    
    /*clears current order for
    *clean slate when new object created
    */
    public BurgerOrder()
    {
        clearOrder();
    }
    
    //sets default burger size and addition options
    public void clearOrder()
    {
        setBurgerSize(BurgerSize.Single);
        setCheese(false);
        setBacon(false);
        setMeal(false);
    }
    
    //sets Burger size
    public void setBurgerSize(BurgerSize size)
    {
        burgerSize = size;
    }
    
    //sets cheese option
    public void setCheese(boolean selected)
    {
        cheeseSelected = selected;
    }
    
    //sets bacon option
    public void setBacon(boolean selected)
    {
        baconSelected = selected;
    }
    
    //sets Meal option
    public void setMeal(boolean selected)
    {
        mealSelected = selected;
    }
    
    //sets quantity of current order
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    
    //gets current quantity
    public String getQuantity()
    {
        return Integer.toString(quantity);
    }
    
    //calculates complete cost current order
    private void calculateTotalCost()
    {
        totalCost = 0;
        switch(burgerSize)
        {
            case Single:
                sizeCost = SINGLE_PRICE;
                break;
            case Double:
                sizeCost = DOUBLE_PRICE;
                break;
            default:
                sizeCost = SINGLE_PRICE;
                break;
        }
        
        totalCost = sizeCost;
        
        if(cheeseSelected)
            totalCost += CHEESE_COST;
        if(baconSelected)
            totalCost += BACON_COST;
        if(mealSelected)
            totalCost += MEAL_COST;
        
    }
    
    //calculates total costs of all orders
    public String getFinalCost()
    {
        finalCost += totalCost * quantity;
        return CF.format(finalCost);
    }
    
    //clears total costs of all orders
    public void clearAllOrders()
    {
        finalCost = 0;
    }
    
    //retrieves total costs of current order
    public String getTotalCost()
    {
        calculateTotalCost();
        return CF.format(totalCost);
    }
    
    //get current burger size
    public String getBurgerSize()
    {
        String str;
        switch(burgerSize)
        {
            case Single:
                str = "Single";
                break;
            case Double:
                str = "Double";
                break;
            default:
                str = "Single";
                break;
        }
        return str;
    }
    
    //returns string of complete order
    public String getOrderInformation()
    {
        StringBuilder str = new StringBuilder();
        str.append(getQuantity());
        str.append(" ");
        
        str.append(getBurgerSize());
        
        if(cheeseSelected)
            str.append(", cheese");
        if(baconSelected)
            str.append(", bacon");
        if(cheeseSelected)
            str.append(", meal");
        
        str.append(" at ");
        str.append(Double.toString(totalCost));
        str.append(" each\n");
        
        return str.toString();
    }
}
