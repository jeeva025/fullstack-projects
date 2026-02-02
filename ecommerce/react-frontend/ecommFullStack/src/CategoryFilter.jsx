import React from 'react'

function CategoryFilter({categories, onSelect}) {
    console.log(categories)
    console.log(onSelect)
  return (
    <>
        <select name="" id="categorySelect" className='form-control' onChange={(e)=> onSelect(e.target.value)}>
            <option value="">All Categories</option>
            {categories.map(category =>{
                return(
                <option key={category.id} value={category.id}>{category.name}</option>)
            })}
        </select>
    </>
  )
}


export default CategoryFilter;
