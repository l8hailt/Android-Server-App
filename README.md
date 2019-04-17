# AssignmentFinal

var Hotel = require('../model/hotel')
var io = require('socket.io').listen(server)
console.log('Server is running')

io.sockets.on('connection', (socket) => {
  console.log('Device connected')

  Hotel.find({}, (err, data) => {
   
    io.sockets.emit('server-send-hotel', { hotels: data })
  })
})
