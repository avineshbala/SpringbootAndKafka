@repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findAll;
    OrderItem = findByOrderItemId(id);

}

