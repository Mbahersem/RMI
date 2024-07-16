import React from "react";


// reactstrap components
import {
  Button,
  Card,
  CardHeader,
  CardBody,
  CardFooter,
  CardText,
  FormGroup,
  Form,
  Input,
  Row,
  Col,
} from "reactstrap";

function Login() {

  return (
    <>
      <div className="content">
        <Row>
            <Col md="4">
                
            </Col>
          <Col md="4">
            <Card style={{marginTop: "150px"}}>
              <CardHeader>
                <h5 className="title">Login</h5>
              </CardHeader>
              <CardBody>
                <Form>
                  <Row>
                    <Col md="12">
                      <FormGroup>
                        <label htmlFor="exampleInputEmail1">
                          Email address
                        </label>
                        <Input placeholder="mike@email.com" type="email" />
                      </FormGroup>
                    </Col>
                  </Row>

                  <Row>
                
    
                <Col md="12">
                  <FormGroup>
                    <label htmlFor="password">
                      Password
                    </label>
                    <Input placeholder="password" type="password" />
                  </FormGroup>
                </Col>
                
              </Row>
                  
                  
                  
                </Form>
              </CardBody>
              <CardFooter>
                <Button className="btn-fill" color="green" type="submit">
                  Log in
                </Button>
              </CardFooter>
            </Card>
          </Col>
          <Col md="4">
            
          </Col>
        </Row>
      </div>
    </>
  );
}

export default Login;
