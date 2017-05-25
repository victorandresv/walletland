package walletland.movitech.cl.walletland;


public class ModelBalance {

    Integer Id;
    String Name;
    Integer Quantity;
    String Datetime;

    public ModelBalance(Integer Id, String Name, Integer Quantity, String Datetime){
        this.Id = Id;
        this.Name = Name;
        this.Quantity = Quantity;
        this.Datetime = Datetime;
    }

    public Integer getId() {
        return Id;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public String getDatetime() {
        return Datetime;
    }

    public String getName() {
        return Name;
    }
}
