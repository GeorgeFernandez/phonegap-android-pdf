window.echo = function(str, callback) {
    cordova.exec(callback, function(err) {
        callback('Nothing to echo.');
    }, "Echo", "echo", [str]);
};

function myshow() {
    window.echo("/sdcard/download/HR_Geo.pdf", function(returnvalue) {
        alert(returnvalue);
    });
}
