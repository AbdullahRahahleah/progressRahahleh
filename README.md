

# progressSoftAssignment
progressSoftAssignment

This is abdullah Rahahleah, i have implemented the required assignement which asks to build a system     
that store FX deals into persist DB (Mysql).

In this implementation i did the following:    
1- I used MySql DB, where i build two tables to store the information:    
A. Deals    
B. Deals Details.    
according to my analysis, I found those records used to generate a lot of reports, so:    
A. I selected relational DB.    
B. In the main table (Deals) I define every value as integer values, to make it faster for querying and reporting.    
C. The values sometimes duplicated, for data integrity in addition to performance.  
2- I built the API which can save a records, the bussiness as following:  
A. I do put customized argument validation, (ex, if the user put invalid currency, the response will be clean)  
`{  
"fromCurrency": "invalid currency value"  
}`  
Sample request  
`{  
"dealId": "21",  
"amount": "123",  
"dealTimestamp": "2024-07-09T12:00:00Z",  
"fromCurrency" : "USD",  
"toCurrency": "USD"  
}`  
B. I do put a list of correct currency.  
C. When we read the dealId, I do save it into a cache, to make the exisiting deal validation faster,   
In this validation, I do check if the dealId was processed before or not (checking cache level then DB level).  
D. I do create Entity mapper, where i used the DealDTO to match the request object then i mapped it to deal   
Entity, to make dealing with objects easier.  
E. I do define globale error handling, to change the response when we had error, i used it with sample use cases.  
3- Login,I define a control the security layer, I used JWT implementation, this was the first to do the implementation  
from A-Z.   
A. I do create a filter which filter every request if it's authinticated.  
B. The user sends his user name and password, then we will do validate it with his values at DB.  
then I do create a JWT token using secretkey (defined in the props file), with expiration 30 mins with using HS512 algorithm  
C. When the user retrives the token, he will resend it with every next request, then at our server side we will do validate it.  
D. I do commented the security part, to make it easier for review.

4- Define docker file (it has a problem when i run it using docker desktop when it tried to run the DB, but i didn't have a time  
to check it).

5- If I have a time I will:  
A- unit testing.  
B- Using multi-threading to store the values.