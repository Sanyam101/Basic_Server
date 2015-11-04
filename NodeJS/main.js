var http = require("http");
var url = require("url");
var fs = require("fs");

http.createServer(function(request, response) {
	var pathname = url.parse(request.url).pathname;

	response.writeHead(200, {'Content-Type': 'text/plain'});
	response.end("Hello World\n");
}).listen(8000);