# AssignmentFinal

var Hotel = require('../model/hotel')
var io = require('socket.io').listen(server)
console.log('Server is running')

io.sockets.on('connection', (socket) => {
  console.log('Device connected')

  Hotel.find({}, (err, data) => {
    // res.render('hotel/index', { title: 'Khách sạn', hotels: data });
    io.sockets.emit('server-send-hotel', { hotels: data })

    // console.log(data)
  })
})
