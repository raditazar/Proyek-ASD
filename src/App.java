import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Deck vip1Deck = new Deck();
        Deck vip2Deck = new Deck();
        Deck comDeck = new Deck();

        String size = scan.nextLine();
        String[] sizeDeck = size.split(" ");
        int sizeVip = Integer.parseInt(sizeDeck[0]);
        int sizeCom = Integer.parseInt(sizeDeck[1]);

        while(true){
            String input = scan.nextLine();
            if(input.isEmpty()){
                break;
            }
            
        }
    }
}
