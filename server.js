const express = require('express');
const bodyParser = require("body-parser");
const app = express();
const port = 3000;
const mysql = require("mysql2");


app.use(bodyParser.urlencoded({ extended: false}));
app.use(bodyParser.json());

const dbase = mysql.createConnection({
    host: "localhost",
    port: 3306,
    user: "root",
    password: "root",
    database: "hellothere"
});

dbase.connect(function(err){
    if(err)throw err;

    console.log("Database Connected");
});

app.listen(port, ()=>{console.log("Running on port " + port);
});

app.get('/getPets', function(req,res){
    
    let sql = "SELECT * FROM Pets";
    
    dbase.query(sql, (err, result)=>{
        if(err) throw err;
        
        res.send(result)
        console.log(result);

        
    });
});

app.post('/newPet', (req, res)=>{

    var name = req.body.Name; 
    var age = req.body.Age;
    var phhp = req.body.PhyHP;
    var mhhp = req.body.MenHP;

    let sql = "INSERT INTO 'Pets' ('Name', 'Age', 'PhyHP', 'MenHP') VALUES ('"+name+"','"+age+"','"+phhp+"','"+mhhp+"')";

        dbase.query(sql, (err, result)=>{
            if(err) throw err;

            res.send(result);
        })
})