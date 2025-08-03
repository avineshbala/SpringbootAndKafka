
@RestController
@RequestMapping("/api/order")
public class OrderInventoryController {

    @Autowired
    OrderServiceImpl orderService;
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    

    @RequestMapping(method=RequestMethod.GET, value="/getOrderByCustomer", produces = {"application/json"})
      public Order getOrderByCustomerId(@RequestParam (name="customerId") long customerId) {
            return orderService.findByOrderId();
        }

}
