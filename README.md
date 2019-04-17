# AssignmentFinal

router.get('/api/hotels', (req, res, next) => {
  Hotel.find({}, (err, data) => {
    res.json({ hotels: data })
  })
});

router.get('/api/rooms/:hId', (req, res, next) => {
  Room.find({ hotel_id: req.params.hId })
    .populate('hotel_id')
    .exec((err, data) => {
      // console.log(data)
      res.json({ rooms: data })
    });
});
