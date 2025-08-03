@entity
@Data
@Table(name="order")
public class Order {
    @id
    @GeneratedValue(Strategy=GenerationType.Identity)
    public long id;
    public long customerid;
    public ArrayList<OrderItems>;
    public BigDecimal totalAmount;
    public String status;
    public Date orderDate;
}
