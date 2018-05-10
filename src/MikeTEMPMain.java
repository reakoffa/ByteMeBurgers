import java.util.ArrayList;

public class MikeTEMPMain {

	public static void main(String[] args) {
	
		ArrayList<FoodItem> foodList = FoodItem.createMenu();  //call FoodItem.createMenu call this method when using toWrite
		
		double sum = 0;
		
		for (FoodItem food : foodList) {
			System.out.println(food);
			sum += food.getPrice();
		}
		System.out.println(sum);
	}

}
