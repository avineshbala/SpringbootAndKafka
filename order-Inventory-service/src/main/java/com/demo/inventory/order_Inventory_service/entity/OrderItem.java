@entity
@Data
@Table(name="orderitem")
public class OrderItem {
    @Id
    @GeneratedValue(Strategy=GenerationType.Identity)
    public long id;
    public long productId;
    public int quantity;
    public BigDecimal unitPrice;
    public BigDecimal totalPrice;
    

}
