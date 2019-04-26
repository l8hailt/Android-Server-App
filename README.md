# api in server

- Get all hotels

      router.get('/api/hotels', (req, res, next) => {
        Hotel.find({}, (err, data) => {
          if (err) {
            res.send('Lỗi!!!')
          }
          res.json({ hotels: data })
        })
      });

- Get all rooms

      router.get('/api/rooms', (req, res, next) => {
        Room.find({})
          .populate('hotel_id')
          .exec((err, data) => {
            if (err) {
              res.send('Lỗi!!!')
            }
            res.json({ rooms: data })
          });
      });

- Get all rooms in a hotel

      router.get('/api/rooms/:hId', (req, res, next) => {
        Room.find({ hotel_id: req.params.hId })
          .populate('hotel_id')
          .exec((err, data) => {
            if (err) {
              res.send('Lỗi!!!')
            }
            res.json({ rooms: data })
          });
      });
