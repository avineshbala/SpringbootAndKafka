@Service

public class OrderItemServiceImpl {

    @Autowired
    OrderItemRepository orderItemRepo;
    
    public List<OrderItem> getOrderItem(){
        return orderItemRepo.findAll();
    }
    

}
