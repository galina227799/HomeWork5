import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void add_strokaTS(String name, String tel, HashMap spr){
        ArrayList<String> telNumbers = new ArrayList<String>();
        if(spr.containsKey(name)) {
            telNumbers = (ArrayList<String>) spr.get(name);
            telNumbers.add(tel);
        }
        else{
            telNumbers.add(tel);
            spr.put(name,telNumbers);
        }
    }
    public static void main(String[] args) {

        HashMap<String, ArrayList> telSpr = new HashMap<>();

        add_strokaTS("Кротов Павел Сергеевич","79311789655",telSpr);
        add_strokaTS("Сидорова Елена Евгеньевна","79103456865",telSpr);
        add_strokaTS("Иванов Сергей Петрович","79207685988",telSpr);
        add_strokaTS("Иванов Сергей Петрович","79207685987",telSpr);
        add_strokaTS("Иванов Сергей Петрович","79207685986",telSpr);
        add_strokaTS("Сидорова Елена Евгеньевна","79103456864",telSpr);

        List list = new ArrayList(telSpr.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String,ArrayList<String>>>(){
            @Override
            public int compare(Map.Entry<String,ArrayList<String>> o1, Map.Entry<String,ArrayList<String>> o2) {
               return o2.getValue().size()- o1.getValue().size();
            }
        });

        for (int i = 0; i < list.size() ; i++) {
            String v = list.get(i).toString().split("=")[0];
            System.out.println(v+" : "+telSpr.get(v));
        }


    }

}