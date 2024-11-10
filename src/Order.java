public class Order {
    private Deck vip1Deck;
    private Deck vip2Deck;
    private Deck comDeck;
    private Deck waitList;
    private int vipTicket;
    private int comTicket;

    public Order(){
        this.vip1Deck = new Deck();
        this.vip2Deck = new Deck();
        this.comDeck = new Deck();
    }

    public void register(String name, int rating, int age, int systolic, int diastolic){
        Penumpang penumpang = new Penumpang(name, rating, age, systolic, diastolic);
        if(normalBloodPressure(penumpang)){
            if(rating >= 9){
                vip1Deck.addPenumpang(penumpang);
                vipTicket++;
            }else if(rating >= 7){
                vip2Deck.addPenumpang(penumpang);
                vipTicket++;
            }else{
                comDeck.addPenumpang(penumpang);
                comTicket++;
            }
        }else{
            waitList.moveToWaitList(penumpang);
        }
    }

    public boolean normalBloodPressure(Penumpang penumpang){
        int systolic = penumpang.getSystolic();
        int diastolic = penumpang.getDiastolic();
        return(systolic >= 90 && systolic <= 120) && (diastolic >= 60&& diastolic <= 79);
    }

    public void resize(String priority, int newSize){
        Deck updateDeck = vip1Deck;
        switch(priority){
            case "VIP1":
                updateDeck = vip1Deck;
                vip2Deck.resize(newSize);
                break;
            case "COM":
                updateDeck = comDeck;
                break;
        }
        updateDeck.resize(newSize);

    }

    public void injectByQueue(String priority, int N){
        Deck tempDeck = null;
        switch (priority) {
            case "VIP1":
                tempDeck = vip1Deck;
                break;
            case "VIP2":
                tempDeck = vip2Deck;
                break;
            case "COM":
                tempDeck = comDeck;
                break;
            default:
                break;
        }
        for(int i = 0; i < N; i++){
            if(!tempDeck.isFull()){
                Penumpang penumpang = tempDeck.removePenumpang();
                Penumpang waitListPenumpang = waitList.removeWaitList();
                if(waitListPenumpang != null){
                    tempDeck.addPenumpang(waitListPenumpang);
                }
            }
        }
    }

    public void injectByTicket(String ticket){
        String[] parts = ticket.split("-");
        String priority = parts[0];
        int noTicket = Integer.parseInt(parts[1]);
        Deck tempDeck = null;
        switch (priority) {
            case "VIP1":
                tempDeck = vip1Deck;
                break;
            case "VIP2":
                tempDeck = vip2Deck;
                break;
            case "COM":
                tempDeck = comDeck;
                break;
            default:
                break;
        }

        Penumpang penumpang = tempDeck.removePenumpang();
        Penumpang waitLisPenumpang = waitList.removeWaitList();
        if(waitLisPenumpang != null){
            tempDeck.addPenumpang(waitLisPenumpang);
        }
    }

    public void skip(String ticket){

    }
}
