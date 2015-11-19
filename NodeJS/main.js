const PORT = 8000;

var http = require("http");
var url = require("url");
var fs = require("fs");

var server = http.createServer(function(request, response) {
	var pathname = url.parse(request.url).pathname;

	response.writeHead(200, {'Content-Type': 'text/plain'});
	response.end("Hello World\n");
})

server.listen(PORT, function() {
	console.log("Server started successfully, listening on port " + PORT);
});