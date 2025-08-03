
@entity
@Data
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(Strategy=GeneratedValue.Identity)
    public long id;
    public String name;
    public BigDecimal price;
    public int availableQty;


}
