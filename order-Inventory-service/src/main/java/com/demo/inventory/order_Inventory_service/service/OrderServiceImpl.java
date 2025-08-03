@Service
public class OrderServiceImpl {

    @Autowired
    OrderRepository orderRepo;

    public List<Order> getOrders(){
        return orderRepo.findAll();
    
    }

    public Order getOrderDetailsById(long id){
        return orderRepo.findByOrderId(id);
    }
    

}
