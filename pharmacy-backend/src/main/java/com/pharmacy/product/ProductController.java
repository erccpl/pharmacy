package com.pharmacy.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    private List<Product> displayAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("{productId}")
    private ResponseEntity<Product> displayOneProduct(@PathVariable Long productId) {
        Product product = productService.findProduct(productId);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    private ResponseEntity<Product> addNewProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return new ResponseEntity<>(productService.findProduct(product.getId()), HttpStatus.CREATED);
    }

    @PutMapping("{productId}")
    private ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("{productId}/delete")
    private ResponseEntity<Product> deleteProduct(@PathVariable Long productId){
        Product product = productService.findProduct(productId);
        if (product != null) {
            productService.deleteProduct(productId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }











//    @GetMapping("/product_panel")
//    private String showProducts(Model model){
//        List<Product> products = productService.getAllProducts();
//        model.addAttribute("products", products);
//        return "product_panel";
//    }
//
//    @GetMapping("/new")
//    private String showNewProductForm(Model model) {
//        Product product = new Product();
//        model.addAttribute("product", product);
//        return "new_product";
//    }
//
//    @PostMapping("/save")
//    public String saveProduct(@ModelAttribute("product") Product product){
//        productService.addProduct(product);
//        return "redirect:/";
//    }
//
//    @GetMapping("/edit/{productId}")
//    public ModelAndView showEditProduct(@PathVariable Long productId){
//        ModelAndView mav = new ModelAndView("edit_product");
//        Product product = productService.getProduct(productId);
//        mav.addObject("product", product);
//        return mav;
//    }
//
//    @GetMapping("/delete/{productId}")
//    public String deleteProduct(@PathVariable Long productId){
//        productService.deleteProduct(productId);
//        return "redirect:/";
//    }

}
