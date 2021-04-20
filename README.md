# Sales Taxes 

### Build & Run
From IntelliJ/Eclipse:
 - Build
 - Run SalesTaxes.main()
 
From command line:
```
 $> mvn clean package
 $> mvn exec:java -D"exec.mainClass"="com.example.SalesTaxes"
 ```
 
### Execution
```
$> Enter the item list in the following format: {quantity} {item name} at {price} 
$> Press 0 to finish

$> Please enter new item: 
1 book at 12.49
$> Please enter new item: 
0

1 book: 12.49
Sales Taxes: 0.0
Total: 12.49
```