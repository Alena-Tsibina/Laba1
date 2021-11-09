package Sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Contact {
	String	name;
	String surname;
	String phone;
	int ClientNumber;
	Float Capital;
	
	public Contact(String name, String surname, String phone, int ClientNumber, float Capital) {
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.ClientNumber = ClientNumber;
		this.Capital = Capital;
	}
	
	public void AddCapital(float capital) {
		this.Capital += capital;
	}
	
	void print() {
		System.out.printf("%20s %20s %12s %d %f\n", name, surname, phone, ClientNumber, Capital);
	}
	
	void printToFile(PrintStream stream) {
		stream.printf("%20s %20s %12s %d %f\r\n", name, surname, phone, ClientNumber, Capital);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contact guide[] = new Contact[12];
		guide[0] = new Contact("Antonina", "Vorobyeva", "345-40-20", 3, 3000);
		guide[1] = new Contact("Alena", "Sergeeva", "345-50-20", 1, 5000);
		guide[2] = new Contact("Veronika", "Ilyina", "345-40-10", 6, 9000);
		guide[3] = new Contact("Grigoriy", "Sheremet", "354-40-20", 2, 4000);
		guide[4] = new Contact("Irina", "Smirnova", "345-71-50", 4, 8000);
		guide[5] = new Contact("Polina", "Ivanova", "345-88-20", 8, 10000);
		guide[6] = new Contact("Anatoliy", "Popov", "345-34-20", 5, 7000);
		guide[7] = new Contact("Vasilisa", "Novikova", "389-40-20", 12, 9000);
		guide[8] = new Contact("Arkadiy", "Lebedev", "345-45-20", 7, 5000);
		guide[9] = new Contact("Vera", "Vasilyeva", "345-32-20", 11, 1000);
		guide[10] = new Contact("Artem", "Vinogradov", "345-54-20", 10, 3000);
		guide[11] = new Contact("Victor", "Bogdanov", "345-98-20", 9, 4000);
	
		guide[5].AddCapital(1000);
		
		for (int i = 0 ; i < guide.length; i++) {
			int j_max = i;
			for (int j = i+1; j < guide.length; j++) {
				if ((guide[j_max].Capital < guide[j].Capital) || (((float)guide[j_max].Capital == (float)guide[j].Capital)&&(guide[j_max].ClientNumber > guide[j].ClientNumber))) {
					j_max = j;
				}
			}	
			Contact temp = guide[i];
			guide[i] = guide[j_max];
			guide[j_max] = temp;
			
			guide[i].print();
		}
		
		try {
			PrintStream out = new PrintStream(new File(".\\1.txt"));
			for (Contact contact : guide) {
				contact.printToFile(out);
			}
		}	catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
		}
		
	}

}

