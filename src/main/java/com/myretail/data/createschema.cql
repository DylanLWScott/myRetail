CREATE TABLE dylanmyretail.products (
  productid bigint PRIMARY KEY,
 price decimal,
 currency_code text
);

#COPY dylanmyretail.products (productid,price,currency_code) from 'productstoload.csv' with delimiter=';' and HEADER = TRUE;