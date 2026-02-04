import React, { useEffect, useState } from "react";
import ProductList from "./ProductList";
import CategoryFilter from "./CategoryFilter";
function App() {
  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [searchTerm, setSearchTerm] = useState("");
  const [sortOrder, setSortOrder] = useState("asc");

  useEffect(() => {
    fetch("http://localhost:8080/api/products")
      .then((response) => response.json())
      .then((data) => setProducts(data));

    fetch("http://localhost:8080/api/categories")
      .then((response) => response.json())
      .then((data) => setCategories(data));
  }, []);

  function handleSearchChange(e) {
    setSearchTerm(e.target.value);
  }

  function handleSortChange(e) {
    setSortOrder(e.target.value);
  }

  // function handleCategorySelect(categoryId){
  //   setCategories(categoryId ? Number(categoryId):null)
  // }
  function handleCategorySelect(categoryId) {
    setSelectedCategory(categoryId ? Number(categoryId) : null);
  }

  const filteredProducts = products
    .filter((product) => {
      return (
        (selectedCategory ? product.category.id === selectedCategory : true) &&
        product.name.toLowerCase().includes(searchTerm.toLowerCase())
      );
    })
    .sort((a, b) => {
      if (sortOrder === "asc") {
        return a.price - b.price;
      }
      return b.price - a.price;
    });

  return (
    <div className="container">
      <h1 className="my-4">Product Catalog</h1>
      <div className="row align-items-center mb-4">
        <div className="col-md-3 col-sm-12 mb-12">
          <CategoryFilter
            categories={categories}
            onSelect={handleCategorySelect}
          />
        </div>

        <div className="col-md-5 col-sm-12 mb-2">
          <input
            type="text"
            className="form-control"
            onChange={handleSearchChange}
            placeholder="Search for products"
          />
        </div>
        <div className="col-md-4 col-sm-12 mb-2">
          <select
            className="form-control"
            onChange={handleSortChange}
            name=""
            id=""
          >
            <option value="asc">Sort by Price : Low to High</option>
            <option value="des">Sort by Price : High to Low</option>
          </select>
        </div>
      </div>
      <div>
        {filteredProducts.length ? (
          //Display Products
          <ProductList products={filteredProducts} />
        ) : (
          //No Products Found
          <p>No products Fount</p>
        )}
      </div>
    </div>
  );
}

export default App;
