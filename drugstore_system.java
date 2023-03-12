import java.util.Scanner;
import java.util.ArrayList;

class Drug
{
	private String name;
	
	private int prise;
	
	private int amount;
	
	public int getPrise()
	{
		return this.prise;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getAmount()
	{
		return this.amount;
	}

	public void buy(int count)
	{
		this.amount -= count;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setPrise(int prise)
	{
		this.prise = prise;
	}
	
	public void setAmount(int amount)
	{
		this.amount = amount;
	}
	
}

class DrugStore
{
	ArrayList<Drug> drugs = new ArrayList<Drug>();
	
	private Scanner scanner = new Scanner(System.in);
	
	public void add_drug()
	{
		
		Drug drug = new Drug();
		
		String name;
		int prise;
		int amount;
		
		System.out.println();
		
		System.out.print("Enter drug name: ");
		name = scanner.next();
		
		System.out.print("Enter drug prise: ");
		prise = scanner.nextInt();
		
		System.out.print("Enter drug amount: ");
		amount = scanner.nextInt();
		
		drug.setAmount(amount);
		drug.setName(name);
		drug.setPrise(prise);
		
		drugs.add(drug);
			
		
	}
	
	public void check_drugs()
	{
		for (int i = 0; i < drugs.size(); i++)
		{
			if (drugs.get(i).getAmount() == 0)
			{
				System.out.println(drugs.get(i).getName() + " is ended");
				drugs.remove(i);
			}
		}
	}
	
	public void buy_drug(int index, int amount)
	{
		if (index < drugs.size())
		{
			
			if (amount <= drugs.get(index).getAmount())
			{
				drugs.get(index).buy(amount);
			}
			
			else
			{
				System.out.println("You want to buy too many drugs\nAmount: " + drugs.get(index).getAmount());
			}
		}
		
		else
		{
			int size = drugs.size() - 1;
			
			System.out.println("Invalid number\nMax number: " + size);
		}
		
	}
	
	public void get_drug_data(int index)
	{
		System.out.println("Name: " + drugs.get(index).getName());
		System.out.println("Prise: " + drugs.get(index).getPrise());
		System.out.println("Amount: " + drugs.get(index).getAmount());
	}
}

public class drugstore_system
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		DrugStore drugstore = new DrugStore();
		
		while (true)
		{
			System.out.print("Enter action\n1. buy drug\n2. add drug\n3. get data about drug\n4. check drugs\n5. exit\n\n");
			int mode = scanner.nextInt();
			
			int index;
			
			switch (mode)
			{
				case 1:
					
					System.out.println("Enter drug number: ");
					index = scanner.nextInt();
					
					System.out.print("Enter amount: ");
					int amount = scanner.nextInt();
					
					drugstore.buy_drug(index, amount);
					
					break;
					
				case 2:
					
					drugstore.add_drug();
					
					break;
					
				case 3:
					
					System.out.print("Enter drug index: ");
					index = scanner.nextInt();
					
					drugstore.get_drug_data(index);
					break;
					
				case 4:
					
					drugstore.check_drugs();
					
					break;
					
				case 5:
					
					System.exit(0);
					
			}
		}
	}
}