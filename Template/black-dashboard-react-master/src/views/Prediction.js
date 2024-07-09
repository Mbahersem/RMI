import React, { useState, useEffect } from 'react';
import { Row, Col, Card, CardHeader, CardBody, CardTitle, Button } from 'reactstrap';
import NotificationAlert from 'react-notification-alert';

function App() {
  const [formData, setFormData] = useState({
    azote: '',
    phosphore: '',
    potassium: '',
    ph: '',
    temperature: '',
    humidite: '',
    typeDeSol: ''
  });

  const [prediction, setPrediction] = useState('');
  const [explication, setExplication] = useState('');

  const notificationAlertRef = React.useRef(null);

  useEffect(() => {
    // Mocking backend data retrieval
    async function fetchData() {
      try {
        // Replace with actual API call to fetch crop parameters
        const response = await fetch('/api/crop-parameters');
        const data = await response.json();

        // Update state with fetched data
        setFormData({
          azote: data.azote,
          phosphore: data.phosphore,
          potassium: data.potassium,
          ph: data.ph,
          temperature: data.temperature,
          humidite: data.humidite,
          typeDeSol: data.typeDeSol
        });

        // Mock response for prediction
        const mockPrediction = {
          prediction: 'Wheat',
          explication: 'Based on the input data, Wheat is predicted to be the suitable crop.',
        };
        setPrediction(mockPrediction.prediction);
        setExplication(mockPrediction.explication);

        // Notify user about data update
        notify('tc'); // Notify with top center position
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    }

    fetchData();
  }, []);

  const notify = (place) => {
    var color = Math.floor(Math.random() * 5 + 1);
    var type;
    switch (color) {
      case 1:
        type = 'primary';
        break;
      case 2:
        type = 'success';
        break;
      case 3:
        type = 'danger';
        break;
      case 4:
        type = 'warning';
        break;
      case 5:
        type = 'info';
        break;
      default:
        break;
    }
    var options = {
      place: place,
      message: (
        <div>
          <div>
            Welcome to <b>GreenView Dashboard</b> - Predict and analyze your agricultural data.
          </div>
        </div>
      ),
      type: type,
      icon: 'tim-icons icon-bell-55',
      autoDismiss: 7,
    };
    notificationAlertRef.current.notificationAlert(options);
  };

  return (
    <>
      <div className="content">
        <div className="react-notification-alert-container">
          <NotificationAlert ref={notificationAlertRef} />
        </div>
        <Row>
          <Col md="6">
            <Card className="card-stats">
              <CardHeader>
                <CardTitle tag="h4">Crop Parameters</CardTitle>
              </CardHeader>
              <CardBody>
                <div className="form-group">
                  <label htmlFor="azote">Nitrogen:</label>
                  <input
                    type="text"
                    id="azote"
                    value={formData.azote}
                    readOnly
                    className="form-control"
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="phosphore">Phosphorus:</label>
                  <input
                    type="text"
                    id="phosphore"
                    value={formData.phosphore}
                    readOnly
                    className="form-control"
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="potassium">Potassium:</label>
                  <input
                    type="text"
                    id="potassium"
                    value={formData.potassium}
                    readOnly
                    className="form-control"
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="ph">pH:</label>
                  <input
                    type="text"
                    id="ph"
                    value={formData.ph}
                    readOnly
                    className="form-control"
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="temperature">Temperature:</label>
                  <input
                    type="text"
                    id="temperature"
                    value={formData.temperature}
                    readOnly
                    className="form-control"
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="humidite">Humidity:</label>
                  <input
                    type="text"
                    id="humidite"
                    value={formData.humidite}
                    readOnly
                    className="form-control"
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="typeDeSol">Soil Type:</label>
                  <input
                    type="text"
                    id="typeDeSol"
                    value={formData.typeDeSol}
                    readOnly
                    className="form-control"
                  />
                </div>
              </CardBody>
            </Card>
          </Col>
          <Col md="6">
            <Card className="card-stats">
              <CardHeader>
                <CardTitle tag="h4">Prediction Results</CardTitle>
              </CardHeader>
              <CardBody>
                <div className="form-group">
                  <label htmlFor="prediction">Prediction:</label>
                  <textarea
                    id="prediction"
                    value={prediction}
                    readOnly
                    className="form-control"
                    rows="3"
                    placeholder="Prediction result..."
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="explication">Explanation:</label>
                  <textarea
                    id="explication"
                    value={explication}
                    readOnly
                    className="form-control"
                    rows="5"
                    placeholder="Explanation..."
                  />
                </div>
                <div className="form-group text-center">
                  <Button color="primary" >
                    Tell me more
                  </Button>
                </div>
              </CardBody>
            </Card>
          </Col>
        </Row>
      </div>
    </>
  );
}

export default App;