package ArrayConcept;

public class Item {

    private Integer id;
    private String name;

    public void setId(Integer id, String name){
        this.id=id;
        this.name=name;
    }

    public Integer getId(){
        return id;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public Item(){

    }

    public Item(Integer id, String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public String toString(){
        return "Item{"+"id="+id+", name="+name+"}";
    }


}
