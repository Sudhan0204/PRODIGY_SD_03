package pit;
import java.util.*;
import java.util.ArrayList;

 class contact{
	 private String name;
	 private String Email;
	 private String Phonenumber;

	 public contact(String Name,String Email, String Phonenumber ) {
		 this.name=Name;
		 this.Email=Email;
		 this.Phonenumber=Phonenumber;
	 }
	
	 public String getname()
	 {
		 return name;
	 }
	 public void setName(String name) {
		 this.name=name;
	 }

	 public String getemail() {
		 return Email;
	 }
	 public void setEmail(String Email) {
		 this.Email=Email;
	 }
	 
	 public String getPhonenumber() {
		 return Phonenumber;
	 }
	 public void setPhonenumber(String Phonenumber) {
		 this.Phonenumber=Phonenumber;
	 }
	 
	 @Override
	    public String toString() {
	        return "Name: " + name + ", Phone Number: " + Phonenumber + ", Email Address: " + Email;
	    }
	 
}
public class ContactManager {

	private static ArrayList<contact> contacts=new ArrayList<>();
	private static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
	boolean exit = false;
	while(!exit) {
		System.out.println("Contact Manager");
		System.out.println("1. Add a new Contact");
		System.out.println("2. View a Contact");
		System.out.println("3. Edit a Contact");
		System.out.println("4. Delete a Contact");
		System.out.println("5. Exit");
		
		int choice=sc.nextInt();
		sc.nextLine();
		
		switch(choice) {
		case 1:
            addContact();
            break;
        case 2:
            viewContacts();
            break;
        case 3:
            editContact();
            break;
        case 4:
            deleteContact();
            break;
        case 5:
            exit = true;
            System.out.println("Exiting...");
            break;
        default:
            System.out.println("Invalid choice. Please enter a number between 1 and 5.");
    
		}
	}
	sc.close();
	}
	
	private static void addContact() {
		System.out.println("Enter a name");
		String Name=sc.nextLine();
		System.out.println("Enter a email");
		String Email=sc.nextLine();
		System.out.println("Enter a phonenumber");
		String Phonenumber=sc.nextLine();
		
		contact Contacts=new contact( Name,Email,Phonenumber);
		contacts.add(Contacts);
	System.out.println("Contact Added Successfully");
	
	}

	
    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("Contacts:");
            for (contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    private static void editContact() {
        System.out.print("Enter the name of the contact to edit: ");
        String name = sc.nextLine();

        for (contact contact : contacts) {
            if (contact.getname().equalsIgnoreCase(name)) {
                System.out.print("Enter new phone number: ");
                String newPhoneNumber = sc.nextLine();
                contact.setPhonenumber(newPhoneNumber);

                System.out.print("Enter new email address: ");
                String newEmailAddress = sc.nextLine();
                contact.setEmail(newEmailAddress);

                System.out.println("Contact updated successfully!");
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    private static void deleteContact() {
        System.out.print("Enter the name of the contact to delete: ");
        String name = sc.nextLine();

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getname().equalsIgnoreCase(name)) {
                contacts.remove(i);
                System.out.println("Contact deleted successfully!");
                return;
            }
        }

        System.out.println("Contact not found.");
    }
}
