import java.util.ArrayList;
import java.util.Scanner;

// Message class to store message details
class Message {
    private String sender;
    private String recipient;
    private String content;

    // Constructor
    public Message(String sender, String recipient, String content) {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
    }

    // Getters
    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getContent() {
        return content;
    }
}

// Chat class to manage sending and receiving messages
class Chat {
    private ArrayList<Message> messages;

    // Constructor
    public Chat() {
        messages = new ArrayList<>();
    }

    // Method to send a message
    public void sendMessage(String sender, String recipient, String content) {
        messages.add(new Message(sender, recipient, content));
        System.out.println("Message sent from " + sender + " to " + recipient);
    }

    // Method to display all messages
    public void displayChatHistory() {
        System.out.println("\n--- Chat History ---");
        for (Message message : messages) {
            System.out.println("From: " + message.getSender() + " | To: " + message.getRecipient());
            System.out.println("Message: " + message.getContent());
            System.out.println("--------------------");
        }
    }
}

public class SimpleChatApplication {
    public static void main(String[] args) {
        Chat chat = new Chat();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nChat Application Menu:");
            System.out.println("1. Send Message");
            System.out.println("2. View Chat History");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1: // Send Message
                    System.out.print("Enter sender's name: ");
                    String sender = scanner.nextLine();
                    System.out.print("Enter recipient's name: ");
                    String recipient = scanner.nextLine();
                    System.out.print("Enter message content: ");
                    String content = scanner.nextLine();
                    chat.sendMessage(sender, recipient, content);
                    break;

                case 2: // View Chat History
                    chat.displayChatHistory();
                    break;

                case 3: // Exit
                    System.out.println("Exiting Chat Application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option! Please choose again.");
            }

        } while (choice != 3);

        scanner.close();
    }
}
