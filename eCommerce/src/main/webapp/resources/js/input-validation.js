function validateProfileForm() {
    console.log('Input validation form in...');
    var name = document.forms["profile"]["name"].value;
    var phone_no = document.forms["profile"]["phone_no"].value;
    var mail = document.forms["profile"]["mail"].value;
    var password = document.forms["profile"]["password"].value;
    var District = document.forms["profile"]["District"].value;
    var UpaZilla = document.forms["profile"]["UpaZilla"].value;
    var RoadNo = document.forms["profile"]["RoadNo"].value;
    if (name == null||name==""|| phone_no==null||phone_no==""|| mail==null||mail==""|| password==null||password==""|| District==null||District==""|| UpaZilla==null||UpaZilla==""|| RoadNo==null||RoadNo=="") {
        alert("Form must be filled out");
        return false;
    }
    return true;
}