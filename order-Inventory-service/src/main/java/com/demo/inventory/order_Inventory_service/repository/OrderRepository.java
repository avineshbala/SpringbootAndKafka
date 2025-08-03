
@repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByOrderId(id);
    List<Order> findAll;

}
