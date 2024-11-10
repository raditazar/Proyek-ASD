public class Deck {
    int sizeVip;
    int sizeCom;
    private Queue<Penumpang> waitList;
    private ArrayList<Penumpang> passengers;

    public Deck(){
        passengers = new ArrayList<>();
        waitList = new Queue<>();
    }

    public boolean isFull(){
        return passengers.size() >=  sizeVip + sizeCom;
    }

    public void addPenumpang(Penumpang penumpang){
        if(!isFull()){
            passengers.add(penumpang);
        }else{
            moveToWaitList(penumpang);
        }
    }
    public Penumpang removeWaitList(){
        Penumpang temp = waitList.dequeue();
        return temp;
    }
    public Penumpang removePenumpang(){
        if(passengers.isEmpty()){
            return null;
        }
        Penumpang temp = passengers.get(0);
        passengers.remove(0);
        if(!waitList.isEmpty()){
            passengers.add(waitList.dequeue());
        }
        return temp;
    }

    public void moveToWaitList(Penumpang penumpang){
        waitList.enqueue(penumpang.getRating(), penumpang);
    }

    public void resize(int newSize){
        while(passengers.size() > newSize){
            passengers.remove(passengers.size()-1);
            if(!waitList.isEmpty()){
                passengers.add(waitList.dequeue());
            }
        }
    }
}
