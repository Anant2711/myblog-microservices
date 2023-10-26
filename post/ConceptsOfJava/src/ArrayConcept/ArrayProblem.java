package ArrayConcept;

import java.util.Arrays;

public class ArrayProblem {

    public static void main(String[] args) {
        Item mobile = new Item(1,"Iphone");
        Item laptop = new Item(2, "Dell");

        Item[] items = {mobile, laptop};

        System.out.println(Arrays.toString(items));

        Item[] newitem = add(mobile,items);
        System.out.println(Arrays.toString(newitem));

    }

    private static Item[] add(Item val, Item[] array){
        int length = array.length;

        Item[] newitems = Arrays.copyOf(array,length+5);
        newitems[length] = val;

        return newitems;
    }
}
