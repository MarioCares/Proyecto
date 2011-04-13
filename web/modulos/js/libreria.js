//Objeto Ajax envía y recibe info
function ObjAJAX(){
    var obj;
    if (window.XMLHttpRequest)
        obj = new XMLHttpRequest();
    else{
        try{
            obj = new ActiveXObject("Microsoft.XMLHTTP");
        }
        catch(e){
            alert(e.name+" - " + e.toString());
        }
    }
    return obj;
}

