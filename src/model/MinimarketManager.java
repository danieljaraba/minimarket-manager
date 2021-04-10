package model;

import exceptions.InvalidDayException;
import exceptions.UnderAgeException;
import java.util.ArrayList;

public class MinimarketManager {

    private ArrayList<Client> clients;
    private int visitors;

    public MinimarketManager(){
        this.clients = new ArrayList<>();
        this.visitors = 0;
    }
 //LocalDate.now().getDayOfMonth()
    public boolean registerClient(String type, String id, int day) throws UnderAgeException, InvalidDayException {
        visitors++;
        boolean added = false;
        if(type.equals("TI")){
            throw new UnderAgeException();
        } else{
            if(id.length() > 1){
                if((Integer.parseInt(String.valueOf(id.charAt(id.length()-2))) % 2) == 0){
                    if(!((day % 2) == 0)){
                        clients.add(new Client(type, id));
                        added = true;
                    } else{
                        throw new InvalidDayException();
                    }
                } else{
                    if(!((day % 2) == 1)){
                        clients.add(new Client(type, id));
                        added = true;
                    } else{
                        throw new InvalidDayException();
                    }
                }
            } else{
                if((Integer.parseInt(id) % 2) == 0){
                    if(!((day % 2) == 0)){
                        clients.add(new Client(type, id));
                        added = true;
                    } else{
                        throw new InvalidDayException();
                    }
                } else{
                    if(!((day % 2) == 1)){
                        clients.add(new Client(type, id));
                        added = true;
                    } else{
                        throw new InvalidDayException();
                    }
                }
            }
        }
        return added;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public int getVisitors() {
        return visitors;
    }

    public void setVisitors(int visitors) {
        this.visitors = visitors;
    }
}
