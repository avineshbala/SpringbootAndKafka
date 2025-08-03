@repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    List<Product> findAll;


}
