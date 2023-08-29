import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';

export default function CategoryUpdate() {

const navigate = useNavigate();

const [categoryName, setCategoryName] = useState('');
const [id, setID] = useState(null);

const updateID = useParams();



const viewID = useParams();

  return (
    <div>CategoryUpdate {updateID}</div>
  )
}