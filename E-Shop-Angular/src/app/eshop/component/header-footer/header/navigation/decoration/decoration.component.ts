import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/eshop/model/category';
import { Product } from 'src/app/eshop/model/product';
import { ProductService } from 'src/app/eshop/services/product.service';

@Component({
  selector: 'app-decoration',
  templateUrl: './decoration.component.html',
  styleUrls: ['./decoration.component.css']
})
export class DecorationComponent implements OnInit {
  products: Product[] = [];
  //category!:Category
  //labelcat:string | undefined;
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.initProduit();
    //this.labelcat="meubles";

  }
  initProduit() {
    this.productService.findByCategory("décoration").subscribe((data) => {
      console.log("data category",data);
      this.products = data;
      console.log("products",this.products)
    });
  }
}
