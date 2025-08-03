@Service

public class ProductServiceImpl {
    @Autowired
    ProductRepository productRepo;

    public List<Product> getProducts(){
        return productRepo.findAll();
    }

}
