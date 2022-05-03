import components.queue.Queue;
import components.queue.Queue1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple program to exercise EmailAccount functionality.
 */
public final class EmailAccountMain {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private EmailAccountMain() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.print("Input a full name: ");
        String name = in.nextLine();
        Queue<EmailAccount> emails = new Queue1L<>();

        while (!name.equals("")) {
            String[] splitName = name.split(" ");
            EmailAccount myAccount = new EmailAccount1(splitName[0],
                    splitName[1]);
            emails.enqueue(myAccount);
            for (EmailAccount x : emails) {
                out.println(x.emailAddress());
            }
            out.print("Input a full name: ");
            name = in.nextLine();

        }

//        EmailAccount myAccount = new EmailAccount1("Brutus", "Buckeye");
//        /*
//         * Should print: Brutus Buckeye
//         */
//        out.println(myAccount.name());
//        /*
//         * Should print: buckeye.1@osu.edu
//         */
//        out.println(myAccount.emailAddress());
//        /*
//         * Should print: Name: Brutus Buckeye, Email: buckeye.1@osu.edu
//         */
//        out.println(myAccount);
        in.close();
        out.close();
    }

}
