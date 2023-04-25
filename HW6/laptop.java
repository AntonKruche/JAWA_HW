package HW.HW6;
import java.util.*;
public class laptop {
    
    String manufacturer;
    String color;
    Integer hardDiscCapacity;
    Integer ram;
    
    public laptop(String manufacturer, String color, Integer RAM, Integer hardDiscCapacity){
        this.manufacturer = manufacturer;
        this.color = color;
        this.ram = RAM;
        this.hardDiscCapacity = hardDiscCapacity;

    }
    public String getManufacturer(){
        return this.manufacturer;
    }
    public String getColor(){
        return this.color;
    }
    public Integer getHardDiscCapacity(){
        return this.hardDiscCapacity;
    }
    public Integer getRAM(){
        return this.ram;
    }
    @Override
    public String toString() {
        return String.format("%s, %s, RAM = %d GB, Hard disk capacity = %d GB", this.manufacturer, this.color, this.ram, this.hardDiscCapacity);
    }

    public static void main(String[] args) {
        laptop laptop1 = new laptop("Asus", "Black", 64, 512);
        laptop laptop2 = new laptop("Asus", "White", 128, 1024);
        laptop laptop3 = new laptop("Lenovo", "White", 128, 1024);
        laptop laptop4 = new laptop("Huawei", "Yellow", 64, 512);
        Set<laptop> laptops = new HashSet<laptop>();
        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);
        laptops.add(laptop4);
        Map<Integer, String> filter = getSortParametres();
        laptops = sortLaptops(laptops, filter);
        for(laptop lap: laptops){
            System.out.println(lap);
        }
        // String sad = "White";
        // String mad = "White";
        // System.out.println(mad == sad);
        // System.out.println(sad.equals(mad));

        


    }

    public static Map<Integer,String> getSortParametres(){
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> filterValues = new HashMap<Integer, String>();
        while(true){
            System.out.println("Vvedite number of parameter\n 1 - manufacturer\n 2 - color\n 3 - RAM\n 4 - hardDiscCapacity\n 5 - zakonchit vvod");
            int parameter = Integer.parseInt(scanner.nextLine());
            if(parameter == 5){
                break;
            }
            System.out.println("Vvedite znachenie vibrannogo parametra:");
            String value = scanner.nextLine();
            filterValues.put(parameter, value);
        }
        scanner.close();
        return filterValues;

    }

    public static Set<laptop> sortLaptops(Set<laptop> laptops, Map<Integer, String> filter){
        for(Integer parameter : filter.keySet()){
            Iterator<laptop> iterator = laptops.iterator();
            switch (parameter){
                case 1:
                iterator = laptops.iterator();
                while(iterator.hasNext()){
                    // System.out.println(iterator.next().color);
                    // System.out.println(filter.get(parameter));
                    if(iterator.next().manufacturer.equals(filter.get(parameter)) == false){
                        iterator.remove();
                    }
                }
                    // for(laptop currentLap: laptops){
                    //     if(currentLap.manufacturer != filter.get(parameter)){
                    //         laptops.remove(currentLap);
                    //     }
                    // }
                    break;
                case 2:
                iterator = laptops.iterator();
                while(iterator.hasNext()){
                    // System.out.println(iterator.next().color);
                    // System.out.println(filter.get(parameter));
                    if(iterator.next().color.equals(filter.get(parameter)) == false){
                        iterator.remove();
                    }
                }
                    // for(laptop currentLap: laptops){
                    //     if(currentLap.color != filter.get(parameter)){
                    //         laptops.remove(currentLap);
                    //     }
                    // }
                    break;
                case 3:
                    iterator = laptops.iterator();
                    while(iterator.hasNext()){
                        if(iterator.next().ram < Integer.parseInt(filter.get(parameter))){
                            iterator.remove();
                        }
                    }
                    // for(laptop currentLap: laptops){
                    //     if(currentLap.ram < Integer.parseInt(filter.get(parameter))){
                    //         laptops.remove(currentLap);
                    //     }
                    // }
                    break;
                case 4:
                    iterator = laptops.iterator();
                    while(iterator.hasNext()){
                        if(iterator.next().hardDiscCapacity < Integer.parseInt(filter.get(parameter))){
                            iterator.remove();
                        }
                    }
                    // for(laptop currentLap: laptops){
                    //     if(currentLap.hardDiscCapacity < Integer.parseInt(filter.get(parameter))){
                    //         laptops.remove(currentLap);
                    //     }
                    // }
                    break;
                default:
                    break;
            }
        }
        return laptops;
    }
}